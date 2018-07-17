
package ProcessOperatingInterface;

import Common.ConfigurationService.*;
import Entity.*;


public class SomeProcessOperatingInterfaceClass
{
    
    public String someProcessMethod()
    {
        Common.ConfigurationService.scalarConfig cs = new Common.ConfigurationService.scalarConfig("./someStreamForConfig.txt");
        cs.getTokensFromConfigStream();
        //
        Entity.SomeEntity se = new Entity.SomeEntity();
        String EntityCall = se.getEntityName();
        
        return "someProcessMethod";
    }
    
}
