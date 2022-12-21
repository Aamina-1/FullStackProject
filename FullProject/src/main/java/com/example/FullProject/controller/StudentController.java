package com.example.FullProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.FullProject.model.Administrator;
import com.example.FullProject.model.Student;
import com.example.FullProject.service.Studentservice;



@Controller
public class StudentController {
	private Studentservice studentServ;
	public StudentController (Studentservice studentServ) {// constructor
		this.studentServ=studentServ;
	}
	@GetMapping("/addNewStudent")
	public String createStudent(Model model) {
		Student stdcreateObj= new Student();
		model.addAttribute("stdObj", stdcreateObj);
		return "createStudent";
	}
	@GetMapping("/seeallstudents")// to see all the students
	public String getAllStudentsFromDb(Model model){
		model.addAttribute("studentsList", studentServ.readAllStudents());
		return "studentFrontEnd";

	}
	@PostMapping("/insertStudents") //to save the records in the database
	public String insertToDb(@ModelAttribute("stdObj")  Student std) {
		studentServ.saveStudent(std);  //obj is insert into db by using save 
		return "redirect:/seeallstudents";
	}
	@GetMapping("/updateStudent/{id}") //used to update a record
    public String updateStudent(@PathVariable int id, Student fromdb,Model model) {

        model.addAttribute("update" ,studentServ.updatestudent(id,fromdb));
        return "updateStudent";
    }
	@PostMapping("/updateAndSaveStudent/{id}") //used to save the updated record
	public String updateandSave(@PathVariable int id, @ModelAttribute("update")Student newfromdb ,Student fromdb) {
		Student existingdb=studentServ.updatestudent(id,fromdb);
		existingdb.setFirstname(newfromdb.getFirstname());
		existingdb.setLastname(newfromdb.getLastname());
		existingdb.setFavSub(newfromdb.getFavSub());
		return "redirect:/seeallstudents";
	}

	@GetMapping("/deleteStudent/{id}") //used to delete a particular record from database
	public String deleteFromDb(@PathVariable int id) {

		studentServ.deleteStudent(id);
		return "redirect:/seeallstudents";
	}
	@GetMapping("/Home")
	public String getAlldataFromHome(Model model){
		model.addAttribute("studentsList", studentServ.readAllStudents());
		return "Home";

}
	
	@GetMapping("/contactme")
	public String contact() {
		return "Contact Us";
	}
	@GetMapping("/logout")
	public String logout() {
		
		return "logout";
	}
	@GetMapping("/login")
	public String loginPage(Model model) {
		Administrator admin= new Administrator();
		model.addAttribute("adminObj",admin);
		return "login";
	}
	@GetMapping("/validatingData")
	public String validateLogin(@ModelAttribute("adminObj")Administrator admindetails) {
		if(admindetails.getUserName().equals("aamina@gmail.com")&& admindetails.getPassword().equals("aamina@1")) {
			return "redirect:/Home";
		}
		else  {
			return "redirect:/login";
		}
	}
}
	
	



