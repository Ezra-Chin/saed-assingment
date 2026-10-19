const SMILEY = ":-)"
const EMOJI = "\uD83D\uDE0A"

app.addTextChangeObserver(newText => {
    const text = app.getText();
    const caret = app.getCaretPosition();
    if (caret >= SMILEY.length && text.substring(caret - SMILEY.length, caret) == SMILEY) {
        const start = caret - SMILEY.length;
        app.setText(text.substring(0, start) + EMOJI + text.substring(caret));
        app.setCaretPosition(start + EMOJI.length);
    }
}

)