import java.io.BufferedReader;
import java.util.*;

public class Processor {

    private long totalBytesRequested;
    private Map<String, RequestData> mapResourceToRequestData;
    private Map<String, Long> mapRequestsToNumberOfRequests;

    public Processor() {
        totalBytesRequested = 0L;
        mapResourceToRequestData = new HashMap<>();
        mapRequestsToNumberOfRequests = new HashMap<>();
    }

    public void process(BufferedReader reader) {
        reader.lines().map(line -> line.split("\\s")).forEach(lineArray -> processLine(lineArray));
    }

    private void processLine(String[] line) {
        String time = line[0];
        String resource = line[1];
        Long bytes = Long.parseLong(line[2]);
        
        totalBytesRequested += bytes;
        
        addToMap(time, resource, bytes);
    }

    private void addToMap(String time, String resource, Long bytes) {
        RequestData newRegis = new RequestData(time, bytes);
        mapResourceToRequestData.put(resource, newRegis);
        mapRequestsToNumberOfRequests.put(resource, mapRequestsToNumberOfRequests.getOrDefault(resource, 0L) + 1);        
    }

    public Result getTotalBytes() {
        Result result = new Result(0L, 0L);

        for (Map.Entry<String, RequestData> map: mapResourceToRequestData.entrySet()) {
            long numberOfRequestsSaved = mapRequestsToNumberOfRequests.get(map.getKey()) - 1;
            long resourceBytes = map.getValue().getBytes();
            result.saved += numberOfRequestsSaved * resourceBytes;

            result.cached += resourceBytes;
        }
        return result;    
    } 

    public long getTotalBytesRequested() {
        return totalBytesRequested;
    }

    public long getTotalBytesInCache() {
        return 0L;
    }
    
}
