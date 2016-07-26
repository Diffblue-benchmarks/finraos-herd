/*
* Copyright 2015 herd contributors
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.finra.herd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.finra.herd.model.jpa.UserEntity;

@Component
public class UserDaoTestHelper
{
    @Autowired
    private UserDao userDao;

    /**
     * Creates and persists a new user entity.
     *
     * @param userId the user id
     * @param namespaceAuthorizationAdmin specifies if the user is a namespace authorization administrator
     *
     * @return the newly created user entity
     */
    public UserEntity createUserEntity(String userId, Boolean namespaceAuthorizationAdmin)
    {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(userId);
        userEntity.setNamespaceAuthorizationAdmin(namespaceAuthorizationAdmin);

        return userDao.saveAndRefresh(userEntity);
    }
}
