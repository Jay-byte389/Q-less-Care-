import { Navigate, Outlet } from "react-router-dom";

function ProtectedRoute_doctor() {
    var isLoggedIn = false; 
    var role = false;
    var isLoggedInFromSessionStorage = sessionStorage.getItem("isLoggedIn");
    var roleFromSessionStorage = sessionStorage.getItem("role");

    if (isLoggedInFromSessionStorage != null) {
        if (isLoggedInFromSessionStorage == "true") {
            isLoggedIn = true;
        }
    }

    if (roleFromSessionStorage != null) {
        if (roleFromSessionStorage == "DOCTOR") {
            role = true;
        }
    }

    if (isLoggedIn && role )
        {   
            return <Outlet></Outlet>;
        }
        else {
            return <Navigate to={"/login"} replace={true}/>
        }
   
}

export default ProtectedRoute_doctor;