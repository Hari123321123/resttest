package driver_classes;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test_class.PostTc1;
import test_class.PutTc1;

public class Post_driver_class {
	@Test
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
PostTc1.orchestrator();
	}

}
