/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["../resources/templates/**/*.{html,js}", "../resources/templates/*.{html,js}"], // it will be explained later
  theme: {
    extend: {
      colors: {
        copal: '#283549',
        copalactive: '#67b4c0',
        copalhover:'#354e60',
        copalsecondary: '#67b4c0',
      }
    }
  },
  plugins: [],
}