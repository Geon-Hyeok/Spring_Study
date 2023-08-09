package xyz.itwill.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;
import xyz.itwill10.service.PointBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class PointBoardServiceTest {
	@Autowired
	private PointBoardService pointBoardService;

	@Test
	public void test1() throws Exception {
		PointBoard board = PointBoard.builder().writer("abc123").subject("테스트").build();

		// PointBoardService 클래스의 addPointBoard() 메소드를 호출하여 POINTBOARD 테이블에 게시글 삽입 처리
		// => POINTUSER 테이블에 저장된 회원정보 중 게시글 작성자에 대한 회원정보의 포인트 증가
		// => POINTUSER 테이블에 저장된 회원정보 중 게시글 작성자의 회원정보를 검색하여 반환
		PointUser user = pointBoardService.addPointBoard(board);

		// 게시글 작성자에 대한 회원정보를 기록
		log.info(user.toString());

		// PointBoardService 클래스의 getPointBoardList() 메소드를 호출하여 게시글 목록을 반환받아 기록
		log.info(pointBoardService.getPointBoardList().toString());
	}

	@Test
	public void test2() throws Exception {
		// PointBoardService 클래스의 addPointBoard() 메소드를 호출하여 POINTBOARD 테이블에 저장된 게시글 삭제
		// => POINTUSER 테이블에 저장된 회원정보 중 게시글 작성자에 대한 회원정보의 포인트 감소
		// => POINTUSER 테이블에 저장된 회원정보 중 게시글 작성자의 회원정보를 검색하여 반환
		PointUser user = pointBoardService.removePointBoard(1);

		// 게시글 작성자에 대한 회원정보를 기록
		log.info(user.toString());

		// PointBoardService 클래스의 getPointBoardList() 메소드를 호출하여 게시글 목록을 반환받아 기록
		log.info(pointBoardService.getPointBoardList().toString());
	}
}
