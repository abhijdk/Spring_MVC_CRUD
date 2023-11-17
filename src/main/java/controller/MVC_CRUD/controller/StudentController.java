package controller.MVC_CRUD.controller;

import controller.MVC_CRUD.pojo.Student;
import controller.MVC_CRUD.service.StudentService;
import controller.MVC_CRUD.validator.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentValidator studentValidator;


    //    View All Student
    @GetMapping("/studentView")
    public String getAllStudent( Model model, @RequestParam("id") int id) {
        //logic for show how many number of pagenation
        int countROw=studentService.size(studentService.countROw().size());//count how may rows avalable in my DataBase
        model.addAttribute("countROw",countROw);

        //for showing all student
        List<Student> getAllStudent = studentService.getAllStudent(id*5);
        model.addAttribute("getAllStudent", getAllStudent);
        return "studentView";
    }


    //    Form for collect information
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("student", new Student());
        return "studentAdd";
    }


    //    Add Student
    @PostMapping("/insert")
    public String studentADD(@ModelAttribute @Valid Student student, BindingResult result) {
        studentValidator.validate(student, result);
        if(result.hasErrors()){
            return "studentAdd";
        }

        if (student.getId() == 0) {
            studentService.studentADD(student);
            return "redirect:/studentView?id=0";
        } else {
            studentService.update(student);
            return "redirect://view?id="+student.getId();
        }
    }


    //    Update Student
    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("student", studentService.getSingleStudent(id));//featch single product
        return "studentAdd";
    }


    //    DELETE STUDENT
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        studentService.delete(id);
        return "redirect:/studentView?id=0";
    }


    //    ByID
    @GetMapping("/byId")
    public String pagination(@RequestParam("id") int id,Model model) {
        //logic for show how many number of pagenation
        int countROw=studentService.size(studentService.countROw().size());//count how may rows avalable in my DataBase
        model.addAttribute("countROw",countROw);

        model.addAttribute("getAllStudent",studentService.getAllStudent(id*5));
        return "byId";
    }


//    Single View BYID
    @GetMapping("/view")
    public String view(@RequestParam("id")int id,Model model){
        model.addAttribute("view",studentService.getSingleStudent(id));
        return "view";
    }

    public StudentValidator getStudentValidator() {
        return studentValidator;
    }

    public void setStudentValidator(StudentValidator studentValidator) {
        this.studentValidator = studentValidator;
    }
}
