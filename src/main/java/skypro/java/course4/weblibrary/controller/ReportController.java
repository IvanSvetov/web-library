package skypro.java.course4.weblibrary.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skypro.java.course4.weblibrary.service.EmployeeService;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final EmployeeService employeeService;

    public ReportController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public int report(){

        return employeeService.report();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadReport(@PathVariable int id){

        Resource resource = employeeService.downloadReport(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"report.json\"")
                .body(resource);
    }
}
