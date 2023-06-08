package com.AHNDOIL.Grouping.controller;

import com.AHNDOIL.Grouping.dto.GroupDto;
import com.AHNDOIL.Grouping.entity.GroupEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;
import com.AHNDOIL.Grouping.infra.AuthenticationFacade;
import com.AHNDOIL.Grouping.repository.UserRepository;
import com.AHNDOIL.Grouping.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController {
    private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
    private final GroupService groupService;
    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;

    public GroupController(
            @Autowired GroupService groupService,
            @Autowired AuthenticationFacade authenticationFacade,
            @Autowired UserRepository userRepository
    ) {
        this.groupService = groupService;
        this.authenticationFacade = authenticationFacade;
        this.userRepository = userRepository;
    }



    @GetMapping("read")
    public String readGroups(Model model) {

        String username = authenticationFacade.getUserName();
        UserEntity user = userRepository.findByUsername(username);

        Collection<GroupDto> groupDtos = groupService.readAll(user);

        model.addAttribute("groupDtos", groupDtos);

        return "read-group";
    }
}
