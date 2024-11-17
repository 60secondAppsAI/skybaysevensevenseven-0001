import http from "../http-common"; 

class EmployeeService {
  getAllEmployees(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/employee/employees`, searchDTO);
  }

  get(employeeId) {
    return this.getRequest(`/employee/${employeeId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/employee?field=${matchData}`, null);
  }

  addEmployee(data) {
    return http.post("/employee/addEmployee", data);
  }

  update(data) {
  	return http.post("/employee/updateEmployee", data);
  }
  
  uploadImage(data,employeeId) {
  	return http.postForm("/employee/uploadImage/"+employeeId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new EmployeeService();
