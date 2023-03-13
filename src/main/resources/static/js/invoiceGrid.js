class UpdateStatusSse {

    execute() {
        const evtSource = new EventSource("stream-sse");
        evtSource.addEventListener('invoice/update', event => {
            let data = JSON.parse(event.data);

            let statusTextItem = document.querySelector('.status > span[data-id="' + data.invoiceId + '"]');
            if (!statusTextItem) {
                return;
            }

            statusTextItem.classList.replace("grid-status-" + statusTextItem.textContent, "grid-status-" + data.status)
            statusTextItem.textContent = data.status;
        })
    }
}

