app.directive("w3TestDirective", function() {
    return {
        template : "<h1>Made by a directive!</h1>" +
        		"<h2>Styling Textarea</h2>" +
        		"<p>Use CSS to change the size of the textarea:</p>" +
        		"<form action='/action_page.php'>" +
        		"<textarea name='message' style='width:200px; height:600px;'>The cat was playing in the garden.</textarea>" +
        		"<br>" +
        		"<input type='submit'>" +
        				"</form>"
        		
        		
        		

        		

        		
          		
        		
        		
    };
});