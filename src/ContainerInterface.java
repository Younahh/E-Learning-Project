import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class ContainerInterface {
	public static void main(String[] args) {
        try {
             Runtime rt=Runtime.instance();
             ProfileImpl pc=new ProfileImpl(false);
             pc.setParameter(ProfileImpl.MAIN_HOST,"localhost");
             AgentContainer container =rt.createAgentContainer(pc);
             AgentController agentController = container.createNewAgent("Interface",AgentInterface.class.getName(),new Object[]{});
             // container.start();
             agentController.start();
        } catch (ControllerException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
        }             
        System.out.println("d�marrage du Interface container ");
 }
}
