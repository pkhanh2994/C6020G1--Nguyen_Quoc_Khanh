package com.fluex404.springbootcrud2.controller;

import com.fluex404.springbootcrud2.dao.SiswaDao;
import com.fluex404.springbootcrud2.model.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HttpMappingRestController {
    @Autowired
    private SiswaDao siswaDao;

    @GetMapping("/findOne")
    public Siswa createFindOne(@RequestParam("id") Integer id) {
        Siswa s = new Siswa();
        Siswa tmp = siswaDao.getOne(id);

        //init
        s.setId(tmp.getId());
        s.setNama(tmp.getNama());
        s.setJurusan(tmp.getJurusan());

        return s;
    }


    @PostMapping("/validate")
    public ResponseEntity<?> validatePost(@Validated @RequestBody Siswa siswa, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            List<FieldError> errorBd = new ArrayList<>();
            errorBd.add(bindingResult.getFieldError("nama"));
            errorBd.add(bindingResult.getFieldError("jurusan"));
            return new ResponseEntity<>(errorBd, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            this.siswaDao.save(siswa);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }


}
