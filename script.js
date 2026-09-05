// Universal Theme Toggle with LocalStorage
const body = document.body;
const themeBtn = document.getElementById("themeToggle");
const themeIcon = document.getElementById("themeIcon");

function applyTheme(theme) {
  body.setAttribute("data-theme", theme);
  localStorage.setItem("site-theme", theme);
  if (themeIcon) {
    themeIcon.className = theme === "dark" ? "ti ti-moon" : "ti ti-sun";
  }
}

// Read saved preference or default to dark
const savedTheme = localStorage.getItem("site-theme") || "dark";
applyTheme(savedTheme);

if (themeBtn) {
  themeBtn.addEventListener("click", () => {
    const isDark = body.getAttribute("data-theme") === "dark";
    applyTheme(isDark ? "light" : "dark");
  });
}

// Mobile Drawer Navigation
const menuToggle = document.getElementById("menuToggle");
const menuIcon = document.getElementById("menuIcon");
const mobileMenu = document.getElementById("mobileMenu");

if (menuToggle && mobileMenu) {
  menuToggle.addEventListener("click", () => {
    const isOpen = mobileMenu.classList.toggle("open");
    menuIcon.className = isOpen ? "ti ti-x" : "ti ti-menu-2";
  });
}
