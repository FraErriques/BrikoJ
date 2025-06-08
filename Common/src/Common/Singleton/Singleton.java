
package Common.Singleton;

// a template to encapsulate a private-static field, which has to be unique.
public final class Singleton<T>
{
    private static Singleton istanza;
    private   T connectionProvider;

    private Singleton()
    {
    }

//    public synchronized   T getProvider()
//    {
//        if (connectionProvider == null)
//        {
//            connectionProvider = new Common.DBservice.connectionProvider_postgreSql_Frechet();
//        }// else it's ready.
//        return connectionProvider;
//    }// getInstance().    
    
    public synchronized static Singleton getInstance()
    {
        if (istanza == null)
        {
            istanza = new Singleton();
        }// else it's ready.
        return istanza;
    }// getInstance().

    public void helloWorld()
    {
        System.out.println("Hello World");
    }

}// Singleton
