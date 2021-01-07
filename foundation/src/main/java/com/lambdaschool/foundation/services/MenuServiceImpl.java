package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Menu;
import com.lambdaschool.foundation.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "menuService")
public class MenuServiceImpl implements MenuService
{
    @Autowired
    private MenuRepository menurepos;

    @Transactional
    @Override
    public Menu save(Menu menu)
    {
        return menurepos.save(menu);
    }
}
