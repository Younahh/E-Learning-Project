import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AgentInterface extends Agent {
	
	protected void setup() {
		System.out.println("D�marrage de l'agent :"+this.getAID().getName());		
		try {
			DFAgentDescription Afd = new DFAgentDescription();
			Afd.setName(getAID());
			DFService.register(this, Afd);
			System.out.println(getLocalName()+" Enregistrement de l'agent avec DF");			
		}
		
		catch (FIPAException e) {
			e.printStackTrace();
		}	
		
		Map map = new HashMap();
		map.put("Cours Web Semantic","Web Semantic");
		map.put("Cours Y","Cours Y");
		map.put("Cours Z","Cours Z");
		map.put("Cours 1","Cours 1");
			
	 
		addBehaviour(new CyclicBehaviour() {
			public void action() {
				ACLMessage message = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
				if (message != null) {
					if (map.containsKey(message.getContent())){
						System.out.println("Le cours existe: "+map.get(message.getContent()));
						String Cours = (String)map.get(message.getContent());
						ACLMessage reply = message.createReply();
						try {
							reply.setContentObject(Cours);
						}
						
						catch (IOException e) {
							e.printStackTrace();
						}
						
					myAgent.send(reply);
					}
					
					else {
						String A = "La Cours n'existe pas";
						ACLMessage reply = message.createReply();
						try {
							reply.setContentObject(A);
						}
						
						catch (IOException e) {
							e.printStackTrace();
						}
						
						myAgent.send(reply);
					}
				}
			}
		});
		
		addBehaviour(new CyclicBehaviour() {
			public void action() {
				ACLMessage message = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
				if (message != null) {
					if (message.getContent().equalsIgnoreCase("Afficher le livre")){
						String R = (String)map.remove("Cours X");
						System.out.println("Livre");
						ACLMessage reply = message.createReply();
						reply.setContent("Merci d'avoir s'abonner a ce cours");
						send(reply);
					}
					
					else {
						ACLMessage reply = message.createReply();
						reply.setContent("Au REVOIR");
						send(reply);
					}doDelete();
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

