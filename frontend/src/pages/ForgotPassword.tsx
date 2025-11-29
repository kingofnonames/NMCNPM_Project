import React, { useState } from "react";

const ForgotPasswordPage = () => {
  const [username, setUsername] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    console.log({ username });
  };

  return (
    <div className="w-screen h-screen flex items-center justify-center bg-gradient-to-br from-sky-100 to-sky-200">
      <div className="w-full max-w-sm bg-white p-6 rounded-xl shadow-lg">
        <h2 className="text-2xl font-bold text-center mb-6">
          Đặt lại mật khẩu
        </h2>

        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1 text-left">
              Số Căn cước công dân:
            </label>
            <input
              type="text"
              pattern="^\d{12}$"
              className="w-full p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 outline-none transition"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              placeholder="Nhập số Căn cước công dân"
              required
            />
          </div>
          <button
            type="submit"
            onSubmit={handleSubmit}
            className="w-full py-2 bg-blue-500 text-white rounded-md hover:bg-blue-600 transition"
          >
            Gửi yêu cầu
          </button>
        </form>
      </div>
    </div>
  );
};

export default ForgotPasswordPage;
