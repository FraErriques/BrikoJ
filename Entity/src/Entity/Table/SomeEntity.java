
package Entity.Table;

import Common.ConfigurationService.*;
import java.sql.Connection;
import java.sql.Statement;


public class SomeEntity
{
    public String getEntityName()
    {
        Common.ConfigurationService.scalarConfig cs = new Common.ConfigurationService.scalarConfig("./someFile.txt");
        cs.getTokensFromConfigStream();
        return "SomeEntity";
    }


}// class
