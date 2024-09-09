package com.EventInterface;

import com.model.ModelStudent;
import com.model.ModelUser;
// the interface tell us which action to implement 
public interface EventActionUser {

    public void delete(ModelUser user);

    public void update(ModelUser user);
    
    public void view(ModelUser user);

}
