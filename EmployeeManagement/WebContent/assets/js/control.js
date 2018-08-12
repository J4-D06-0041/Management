function call() {
	console.log('Hello World');
	var request = new XMLHttpRequest();

	request.open('GET', 'http://localhost:8080/EmployeeManagement/login/validate/'+user+'/'+pass', true);
	request.onload = function () {

	  // Begin accessing JSON data here
	  var data = this.response;

	  if (request.status >= 200 && request.status < 400) {
	    console.log(data);
	    alert(data);
	  } else {
	    console.log('error');
	  }
	}

	request.send();
}