import java.util.*;

class Utils
{
    private Map<String, String> inputMap = new HashMap<String, String>();
    public Map<String, String> getPairInput(String[] args)
    {
       for (int i = 0; i < args.length; i += 2) inputMap.put(args[i], args[i + 1]);
       return inputMap;
    }
}

