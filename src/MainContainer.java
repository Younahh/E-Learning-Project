
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class MainContainer {
	public static void main(String[] args) {		
        try {
        	
             Runtime rt=Runtime.instance();
             Properties p = new ExtendedProperties();
             p.setProperty("gui","true");
             ProfileImpl pc=new ProfileImpl(p);
             AgentContainer container =rt.createMainContainer(pc);
             container.start();
             System.out.println("Main container started ");
        } catch (ControllerException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
        }
    }
}