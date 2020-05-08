app.directive("w3TestDirective", function() {
    return {
        template : "<h1>TESTING:</h1>" +
        		
        		"<textarea name='message' style='background-color:black; color:lightgreen; width:700px; height:200px;'>{{outLog}}</textarea>" +
        		"<br>" 		   		
    };
});

