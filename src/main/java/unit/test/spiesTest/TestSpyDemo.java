//package unit.test.spiesTest;//package javaProf.unit.mockito.test.spiesTest;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class TestSpyDemo {
//
//	@Spy
//	List<String> listSpy = new ArrayList<>();
//
//	@Test
//	public void testSpyReturnsRealValues() {
//		String str = "Test Spy";
//
//		listSpy.add(str);
//
//		verify(listSpy).add(str);
//		assertEquals(1, listSpy.size());
//	}
//}