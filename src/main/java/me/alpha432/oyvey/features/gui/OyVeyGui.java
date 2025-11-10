void ShowMinecraftStyleGUI(bool* p_open)
{
    ImGui::SetNextWindowSize(ImVec2(420, 220));
    ImGui::Begin("Mod Menu", p_open, ImGuiWindowFlags_NoResize | ImGuiWindowFlags_NoCollapse);

    // Styling
    ImGui::PushStyleColor(ImGuiCol_WindowBg, ImVec4(0.12f, 0.12f, 0.14f, 1.0f)); // Dark grey
    ImGui::PushStyleColor(ImGuiCol_Header, ImVec4(0.4f, 0.0f, 0.6f, 0.9f));       // Neon purple accents
    ImGui::PushStyleColor(ImGuiCol_HeaderHovered, ImVec4(0.6f, 0.1f, 0.8f, 1.0f));
    ImGui::PushStyleColor(ImGuiCol_Button, ImVec4(0.3f, 0.0f, 0.5f, 0.8f));
    ImGui::PushStyleColor(ImGuiCol_ButtonHovered, ImVec4(0.5f, 0.2f, 0.8f, 1.0f));
    ImGui::PushStyleVar(ImGuiStyleVar_FrameRounding, 6.0f);
    ImGui::PushStyleVar(ImGuiStyleVar_WindowRounding, 10.0f);

    // Minecraft-style font note: you'd load a blocky/pixel font here
    // ImGui::PushFont(minecraftFont);

    static int tab = 0;
    if (ImGui::Button("Combat", ImVec2(200, 25))) tab = 0;
    ImGui::SameLine();
    if (ImGui::Button("Misc", ImVec2(200, 25))) tab = 1;

    ImGui::Separator();

    if (tab == 0) // Combat tab
    {
        ImGui::Text("Combat Modules:");
        static bool triggerbot = false, aimassist = false, hitbox = false, staticHeights = false;
        static int triggerbotMode = 0, aimassistMode = 0;
        static float hitboxSize = 1.0f;
        static ImVec4 triggerColor = ImVec4(1, 0, 1, 1);
        static ImVec4 aimColor = ImVec4(0.8f, 0.2f, 1.0f, 1);

        ImGui::Checkbox("Triggerbot", &triggerbot);
        ImGui::SameLine();
        ImGui::ColorEdit3("##TriggerColor", (float*)&triggerColor, ImGuiColorEditFlags_NoInputs);

        ImGui::Checkbox("AimAssist", &aimassist);
        ImGui::SameLine();
        ImGui::ColorEdit3("##AimColor", (float*)&aimColor, ImGuiColorEditFlags_NoInputs);

        ImGui::Checkbox("Hitbox", &hitbox);
        ImGui::SameLine();
        ImGui::SliderFloat("Size", &hitboxSize, 0.5f, 2.0f);

        ImGui::Checkbox("Static Heights", &staticHeights);
        ImGui::SameLine();
        ImGui::Text("Keybind: [Press to set]");
    }

    else if (tab == 1) // Misc tab
    {
        ImGui::Text("Misc Modules:");
        static bool randomColors = false;
        ImGui::Checkbox("Color Pick: Use Random Colors", &randomColors);
        static ImVec4 miscColor = ImVec4(0.6f, 0.3f, 1.0f, 1);
        ImGui::ColorEdit3("Theme Color", (float*)&miscColor, ImGuiColorEditFlags_NoInputs);
    }

    ImGui::PopStyleVar(2);
    ImGui::PopStyleColor(5);
    ImGui::End();
}
