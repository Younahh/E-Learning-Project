import java.io.IOException;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.wrapper.ControllerException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class AgentUser  extends Agent {
	   @Override
	   protected void setup() {
		  System.out.println("Initialisation de l'agent "+this.getAID().getName());		   
		  try {
			  DFAgentDescription Afd = new DFAgentDescription();
			  Afd.setName(getAID());
			  DFService.register(this, Afd);
			  System.out.println(getLocalName()+" Enregistrement dans l'annuaire DF");
		   } 
		  
		  catch (FIPAException e) {
			   e.printStackTrace();
		  }
		  
	  ACLMessage message = new ACLMessage(ACLMessage.INFORM);
	  message.setContent("Cours Web Semantic");
	  message.addReceiver(new AID("Interface",AID.ISLOCALNAME));
	  send(message);
	   
	  addBehaviour(new CyclicBehaviour(this) {
		  public void action() {
			  ACLMessage message = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
			  if (message != null) {
				  String B = null;
				  try {
					  B = (String) message.getContentObject();
				  }
				  
				  catch (UnreadableException e) {
					  e.printStackTrace();
				  }
				  
				  if (B == "Web Seamantic") {			   		   	   
					  ACLMessage reply = message.createReply();
					  reply.setContent("Afficher le livre");
					  send(reply);
				  }
				  
				  else {
					  ACLMessage reply = message.createReply();
					  reply.setContent("Au Revoir");
					  send(reply);
				  }
				  
				  doDelete();
			  }
			  
			  else {
				  block();
			  }
		  }
	  });
	}
	   
	protected void takeDown() {
		try {
			DFService.deregister(this);
			System.out.println(getLocalName()+" annulation de l'enregistrement avec DF");
		} 
		
		catch (FIPAException e) {
			e.printStackTrace();
		}
	}
}
	   