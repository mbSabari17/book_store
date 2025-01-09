// script.js

// Initialize the counter variable
let count = 0;

// Select the button and counter elements from the DOM
const button = document.querySelector('.click-button');
const counterDisplay = document.getElementById('counter');
console.log(button,counterDisplay)
// Add an event listener to the button for 'click' events
button.addEventListener('click', () => {
    // Increment the counter
    count += 1;
console.log(count)
    
    // Update the counter display text
    counterDisplay.textContent = count;
});