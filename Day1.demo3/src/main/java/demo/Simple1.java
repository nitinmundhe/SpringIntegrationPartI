package demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class Simple1 {
	public Simple1() {
		System.out.println("Simple Constructor   ...   ");
	}
	@Autowired
	private TaskExecutor taskExecutor;
	
	public void m1(int i) {
		Runnable r = ()-> {		
			System.out.println("In runnable of r using   ...   " + Thread.currentThread().getName() +  " i = " + i );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		taskExecutor.execute(r);
	}
}
