package org.scoula.board.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.service.BoardService;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        RootConfig.class,
        ServletConfig.class,
})
@Log4j2
public class BoardControllerTest {
    @Autowired
    BoardService service;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    /*
    MockNvc로 Get 요청 테스트하기
    - Get 요청 만들기
        - MockMvcRequestBuilders.get(url문자열)
    - MockMvc
        - .perform(요청빌더)
            - 지정된 요청을 스프링 MVC가 처리
                -> 지정된 URL을 처리하는 컨트롤러 메서드 호출
            - ResultActions 객체 리턴
            - ResultActions의 andReturn(): 컨트롤러의 처리 결과를 리턴
     - MvcResult
        - 컨트롤러에 의해 구성된 Model 및 View에 대한 정보 및 처리결과(상태 코드) 등을 가짐
        - getModelAndView(): ModelAndView 객체 리턴
     */
    @Test
    public void list() throws Exception {
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) // ResultActions 리턴
                .andReturn() // MvcResult 리턴
                .getModelAndView() // ModelAndView 리턴
                .getModelMap(); // Model 리턴
        log.info(model);
    }

    @Test
    public void create() throws Exception {
        String viewName = mockMvc.perform(MockMvcRequestBuilders.get("/board/create")) // ResultActions 리턴
                .andReturn() // MvcResult 리턴
                .getModelAndView() // ModelAndView 리턴
                .getViewName();
        log.info(viewName);
    }

    /*
    MockMvc로 Post 요청 테스트하기
    - MockMvcRequestBuilders.post(url 문자열)
            .param(키1, 값1) // form 요소
            .param(키2, 값2)
     */
    @Test
    public void postCreate() throws Exception {
        String resultPage = mockMvc.perform(
                MockMvcRequestBuilders.post("/board/create")
                        .param("title", "테스트 새글 제목")
                        .param("content", "테스트 새글 내용")
                        .param("writer", "user1")
        )
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(resultPage);
    }

    /*
    Get 요청의 쿼리 파라미터 테스트
    - MockMvcRequestBuilders.get(url 문자열)
            .param(키1, 값1) // 쿼리 파라미터
            .param(키2, 값2)
     */
    @Test
    public void get() throws Exception {
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("no", "1"))
                .andReturn()
                .getModelAndView()
                .getModelMap();
        log.info(model);
    }

    @Test
    public void update() throws Exception {
        String resultPage = mockMvc.perform(
                MockMvcRequestBuilders.post("/board/update")
                        .param("no", "1")
                        .param("title", "수정된 테스트 새글 제목")
                        .param("content", "수정된 테스트 새글 내용")
                        .param("writer", "user00")
        )
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);
    }

    @Test
    public void delete() throws Exception {
        // 삭제 전 데이터베이스에 게시물 번호 확인할 것
        String resultPage = mockMvc.perform(
                MockMvcRequestBuilders.post("/board/delete")
                        .param("no", "4")
        )
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);
    }
}
