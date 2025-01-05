package org.example.usermanagement.Services;

import org.example.usermanagement.Dto.Userdto;
import org.example.usermanagement.Utils.APIResponse;

public interface Userservice {
    APIResponse<String> save(Userdto userdto);
}
