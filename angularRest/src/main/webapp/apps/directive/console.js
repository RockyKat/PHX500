app.directive("w3TestDirective", function() {
    return {
        template : "<h4>CONSOLE:</h4>" +
        		
        		"<textarea name='message' style='background-color:black; color:lightgreen; width:100%; height:400px;'>{{outLog}}</textarea>" +
        		"<br>" 		   		
    };
});

