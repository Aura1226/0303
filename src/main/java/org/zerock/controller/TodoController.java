package org.zerock.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.dto.TodoDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo")
@Log4j
@RequiredArgsConstructor
public class TodoController {

//	private final TodoMapper mapper;

	@GetMapping({ "/add", "/add2" })
	public void add() {
		log.info("get.........................");
	}
//	@PostMapping(value = "/add", produces = "text/plain")
//	@ResponseBody
//	public String addPost(TodoDTO todoDTO) {
//		
//		log.info("=================================");
//		log.info(todoDTO);
//		
////		Todo todo = Todo.builder().title(todoDTO.getTitle())
////				.complete(todoDTO.getComplete()).build();
//		
////		mapper.insert(todo);
//		
//		return "success";
//	}

	@PostMapping("add")
	public String addPost(@Valid TodoDTO todoDTO, BindingResult result, RedirectAttributes rttr) {

		log.info("=================================");
		log.info(todoDTO);

		if (result.hasErrors()) {
			log.info("has errors" + result);
			return "/todo/add";
		}

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/todo/list";
	}

	@PostMapping("add2")
	@ResponseBody
	public Object add2Post(@Valid TodoDTO todoDTO, BindingResult result) {

		log.info("=================================");
		log.info(todoDTO);

		if (result.hasErrors()) {
			log.info("has errors" + result);
			
			return result.getAllErrors();
		}

		return null;
	}

	@GetMapping("/list")
	public void list(
//			@ModelAttribute("todo")TodoDTO todoDTO, 
			Model model) {
		log.info("list...............");

		List<TodoDTO> list = IntStream.rangeClosed(1, 10).mapToObj(i -> {
			TodoDTO dto = new TodoDTO();
			dto.setTno(i);
			dto.setTitle("aaaa" + i);
			return dto;
		}).collect(Collectors.toList());

		model.addAttribute("list", list);
	}
}
