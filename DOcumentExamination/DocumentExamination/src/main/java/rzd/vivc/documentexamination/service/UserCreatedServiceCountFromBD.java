/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rzd.vivc.documentexamination.repository.UserRepository;

@Component
public class UserCreatedServiceCountFromBD implements UserCreatedService {
    @Autowired
    private UserRepository repository;
    private int i=-1;
    
    @Override
    public int getTotalCount() {
        if(i<0){
            updateTotalCount();
        }
        return i;
    }

    @Override
    public void updateTotalCount() {
        i=repository.getTotalCount();
    }
    
}
