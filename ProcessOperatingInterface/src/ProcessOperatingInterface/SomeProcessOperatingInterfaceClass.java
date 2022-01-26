
package ProcessOperatingInterface;

import Common.ConfigurationService.*;
import Entity.Table.SomeEntity;


public class SomeProcessOperatingInterfaceClass
{
    
    public String someProcessMethod()
    {
        Common.ConfigurationService.scalarConfig cs = new Common.ConfigurationService.scalarConfig("./someStreamForConfig.txt");
        cs.getTokensFromConfigStream();
        //
        Entity.Table.SomeEntity se = new Entity.Table.SomeEntity();
        String EntityCall = se.getEntityName();
        
        return "someProcessMethod";
    }
    
}
