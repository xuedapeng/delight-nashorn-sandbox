package delight.nashornsandbox;

import javax.script.ScriptException;

import org.junit.Ignore;
import org.junit.Test;

import delight.nashornsandbox.exceptions.ScriptCPUAbuseException;
import junit.framework.Assert;

public class TestEngine {
	
	@Test
	public void test() throws ScriptCPUAbuseException, ScriptException {
		
		NashornSandbox sandbox = NashornSandboxes.create();
		
		Assert.assertEquals(null, sandbox.eval("this.engine"));
		
	}
	
	@Ignore
	@Test
	public void test_with_delete() throws ScriptCPUAbuseException, ScriptException {
		
		NashornSandbox sandbox = NashornSandboxes.create();
		
		sandbox.eval("delete this.engine; this.engine.factory;");
		// should fail but doesn't
		sandbox.eval("delete this.engine; this.engine.factory.scriptEngine.compile('var File = Java.type(\"java.io.File\"); File;').eval()");
		
		Assert.assertEquals(null, sandbox.eval("delete this.engine; this.engine.factory;"));
		
	}
	
}
