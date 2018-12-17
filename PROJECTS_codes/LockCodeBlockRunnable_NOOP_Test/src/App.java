import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

	public static void main(String[] args) {

		WorkerSyncMethods worker1 = new WorkerSyncMethods();
		WorkerSynchBlocks worker2 = new WorkerSynchBlocks();
		WorkerMainThread worker3 = new WorkerMainThread();
		worker2.doJob();
		worker1.doJob();
		worker3.doJob();
		
		

	}

}
