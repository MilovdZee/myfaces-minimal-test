let hookedToAjaxEvent = false;

function hookIntoAjaxEvents() {
    if (!hookedToAjaxEvent) {
        window.setTimeout(() => {
            console.log('Hooking into ajax events');
            faces.ajax.addOnEvent(onEventFunction);
            hookedToAjaxEvent = true;
        }, 100);
    }
}

/**
 * AJAX event handler
 * @param data
 */
function onEventFunction(data) {
    const status = data.status; // Can be "begin", "complete" or "success".
    console.log(data);
    switch (status) {
        case "begin": // Before the ajax request is sent.
            break;
        case "complete": // After the ajax response is arrived.
            break;
        case "success": // After update of HTML DOM based on ajax response.
            break;
    }
}

hookIntoAjaxEvents();
