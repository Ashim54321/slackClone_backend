package com.project.workmanagemantSystem.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class WorkSpaceMemberRequest {
    private String email;
    private UUID workspaceCode;
}
