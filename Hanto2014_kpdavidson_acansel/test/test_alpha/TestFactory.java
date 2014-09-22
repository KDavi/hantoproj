package test_alpha;

import static org.junit.Assert.*;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.HantoGameFactory;
import hanto.student_kpdavidson_acansel_.alpha.*;

import org.junit.Test;

public class TestFactory {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		factory.makeHantoGame(HantoGameID.ALPHA_HANTO);
	}

}
