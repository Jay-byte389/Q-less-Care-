import React from 'react';
import './HeroSection.css'; // Ensure you import the CSS file

function about() {
    return (
        <div className="hero-section">
            <h1 className="hero-title">WELCOME TO CITY HOSPITAL</h1>
            <p className="hero-subtitle">We Provide Top & best Medical Services in Pune City.</p>

            <div className="content-section">
                <h2 className="section-title">Vision</h2>
                <p className="section-content">
                    To provide each patient with the world-class care, exceptional service and compassion we would want for our loved ones and To Lead the evolution of healthcare to enable every member of the communities we serve to enjoy a better, healthier life.
                </p>
            </div>

            <div className="content-section">
                <h2 className="section-title">Mission</h2>
                <p className="section-content">
                    The mission of City Hospital is to provide quality health services and facilities for the community, to promote wellness, to relieve suffering, and to restore health as swiftly, safely, and humanely as it can be done, consistent with the best service we can give at the highest value for all concerned.
                </p>
            </div>
        </div>
    );
}
export default about;