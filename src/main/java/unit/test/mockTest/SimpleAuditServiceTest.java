//package unit.test.mockTest;
//
//import org.example._2023_02_24.unit.mock.*;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith(MockitoExtension.class)
//class SimpleAuditServiceTest {
//
//	@Mock  // actually, this is a stub
//    TradeRepository tradeRepository;
//
//	@Mock
//    Trade trade;
//
//	@Mock  // and this one is indeed a mock
//    AuditService auditService;
//
//	@Test
//	public void testAuditLogEntryMadeForNewTrade()  {
//		when(tradeRepository.createTrade(trade)).thenReturn(anyLong());
//
//		TradingService tradingService
//				= new SimpleTradingService(tradeRepository, auditService);
//		tradingService.createTrade(trade);
//
//		verify(auditService).logNewTrade(trade);
//	}
//}