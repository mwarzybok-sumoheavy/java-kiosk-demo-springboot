class UpdateStatusSse {

    execute() {
        let self = this;
        const evtSource = new EventSource("stream-sse");
        evtSource.addEventListener('invoice/update', event => {
            let data = JSON.parse(event.data);

            addInvoiceSnackBar(data);

            let statusTextItem = document.querySelector('.status > span[data-id="' + data.invoiceId + '"]');
            if (!statusTextItem) {
                return;
            }

            statusTextItem.classList.replace("grid-status-" + statusTextItem.textContent, "grid-status-" + data.status)
            statusTextItem.textContent = data.status;
        })

        evtSource.onerror = function(e) {
            evtSource.close();
            self.execute();
        };
    }
}

