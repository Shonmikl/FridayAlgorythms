//package unit.test.spiesTest;//package javaProf.unit.mockito.test.spiesTest;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class MockDemo {
//
//	@Mock
//	List<String> listMock = new ArrayList<>();
//
//	@Test
//	public void testMockReturnsZero() {
//		String str = "Mock";
//
//		listMock.add(str);
//
//		verify(listMock).add(str);
//		assertEquals(0, listMock.size());
//	}
//}