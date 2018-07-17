
package Entity;

import Common.ConfigurationService.*;


public class SomeEntity
{
    public String getEntityName()
    {
        Common.ConfigurationService.scalarConfig cs = new Common.ConfigurationService.scalarConfig("./someFile.txt");
        cs.getTokensFromConfigStream();
        return "SomeEntity";
    }
    
    
}
