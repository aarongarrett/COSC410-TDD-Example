import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class ArgumentParser {
    
    public ArgumentParser() {
        arguments = new ArrayList<>();
        argumentValues = new HashMap<>();
    }
    
    public void addArgument(String argname) {
        arguments.add(argname);
    }
    
    public boolean hasArgument(String argname) {
        return arguments.contains(argname);
    }
    
    public void parse(String[] args) {
        if (args.length != arguments.size()) {
            throw new ArgumentNotFoundException();
        }
        for (int i = 0; i < args.length; i++) {
            argumentValues.put(arguments.get(i), args[i]);
        }
    }
    
    public String get(String argname) {
        return argumentValues.get(argname);
    }
    
    private List<String> arguments;
    private Map<String, String> argumentValues;
}
