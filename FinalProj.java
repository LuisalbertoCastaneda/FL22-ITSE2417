// Dummy class for FinalProject
// Outputs a simple message when implementing begin()

public class FinalProj implements FinalProject
{
    public FinalProj()
    {

    }

    public void begin()
    {
        System.out.println();
        System.out.println("Not implemented at this time");
        System.out.println();
        try
        {
            java.util.concurrent.TimeUnit.SECONDS.sleep(2);
        }
        catch(InterruptedException e)
        {}
    }
}