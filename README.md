# MyFaces Minimal Test
This repo is meant to test MyFaces functionality in a minimal setting.

Start the service with:
```bash
mvn jetty:run
```

Then the service is available on: http://localhost:8080/index.xhtml

# Examples of issues
## h:commandScript not passing arguments to bean 
- https://issues.apache.org/jira/browse/MYFACES-4710
- https://stackoverflow.com/questions/79452661/is-myfaces-4-0-2-hcommandscript-still-supposed-to-function

Open http://localhost:8080/index.xhtml and press the button. The log output of the bean should show the value of 'test' to be 'value' but instead it shows 'null'.

## Source lost in ajax status event listener
- https://stackoverflow.com/questions/79406526/myfaces-4-0-2-does-not-always-seem-to-know-what-the-source-of-the-ajax-event-was

Open http://localhost:8080/page1.xhtml and click on 'to page 2'. In the debug console of the browser you should see the 'source' of the event but after the page switch it is 'null' for the 'success' status event. The 'delay' button does preserve the source like expected.

Page switch:
<pre>
- Object { type: "event", status: "begin", source: a#formPage2:button }
- Object { type: "event", status: "complete", source: a#formPage2:button, responseCode: "200", responseText: '...' }
- Object { type: "event", status: "success", <strong>source: null</strong>, responseCode: "200", responseText: '...' }
</pre>

Delay button:
<pre>
- Object { type: "event", status: "begin", source: input#formPage1:button2 }
- Object { type: "event", status: "complete", source: input#formPage1:button2, responseCode: "200", responseText: '...' }
- Object { type: "event", status: "success", <strong>source: input#formPage1:button2</strong>, responseCode: "200", responseText: '...' }
</pre>
