package demo;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource
public class TestMBeans {

	private String privatestr = "Private";
	protected String protectedstr = "Protected";
	public String publicstr = "Public";

	private String propstr = "pro str var";

	private static String statstr = "Static";

	@ManagedAttribute
	public String getPropstr() {
		return propstr;
	}

	@ManagedAttribute
	public void setPropstr(String propstr) {
		this.propstr = propstr;
	}

	@ManagedOperation
	public void method1() {
		System.out.println("Method1");
	}
	@ManagedOperation
	public String method2() {
		System.out.println("Method1");
		return "Method2";
	}
	
	@ManagedOperation()
	@ManagedOperationParameters({
		@ManagedOperationParameter(name="Number1",description ="The First Number"),
		@ManagedOperationParameter(name="String1",description ="The First String")
	})	
	public String method3(int a,String b) {
		System.out.println("Method2");
		return a+b;
	}
	
	@ManagedOperation
	public String method3(String a,String b) {
		System.out.println("Method2");
		return a+b;
	}
	
	//Not Exposed to outside world
	public void dummy() {				
	}
}