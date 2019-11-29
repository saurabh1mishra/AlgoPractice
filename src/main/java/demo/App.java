package demo;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static <reader> void main(String[] args ) throws IOException {
        String command="curl -X GET  'http://soa-shared.core.cvent.org/accounts/v1/AccountConfig?environment=S400'  -H 'Account-Id: 801409999'  -H 'Authorization: api_key 995723ac147b6f681dae28963541f314'  -H 'Postman-Token: 647cb030-e693-4fad-83bf-6e62703971cf'  -H 'cache-control: no-cache,no-cache'";
        /*ProcessBuilder process = new ProcessBuilder(command);
         InputStream in= process.start().getInputStream();*/
        InputStream in = Runtime.getRuntime().exec(command).getInputStream();
        try ( BufferedReader br = new BufferedReader( new InputStreamReader(in) ) ) {
            String line = br.lines().collect(Collectors.joining());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
