import { test, expect } from '@playwright/test';

test(
  'ModuleTest2',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-051' },
    tag: ['@QADENCE_TC_ID:TC-051'],
  },
  async ({ page }) => {

    //Start - Module - Module Login

    await test.step('#01 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#02 - test', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).click();
    });

    await test.step('#03 - fill', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).fill('standard_user');
    });

    await test.step('#04 - click', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).click();
    });

    await test.step('#05 - fill', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).fill('secret_sauce');
    });

    await test.step('#06 - click', async () => {
      await page.getByRole("button", { name: "Login", exact: true }).click();
    });
    //End - Module - Module Login

    await test.step.skip('#07 - Disabled - click', async () => {
      await page.getByRole("button", { name: "Open Menu", exact: true }).click();
    });

    await test.step.skip('#08 - Disabled - click', async () => {
      await page.getByRole("button", { name: "Login", exact: true }).click();
    });

    await test.step.skip('#09 - Disabled - click', async () => {
      await page.getByRole("button", { name: "Logout", exact: true }).click();
    });

    await test.step.skip('#10 - Disabled - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step.skip('#11 - Disabled - click', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).click();
    });

    await test.step.skip('#12 - Disabled - fill', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).fill('standard_user');
    });

    await test.step.skip('#13 - Disabled - click', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).click();
    });

    await test.step.skip('#14 - Disabled - fill', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).fill('secret_sauce');
    });
    //Start - Module - clickModule

    await test.step.skip('#15 - Disabled - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(0).click();
    });

    await test.step.skip('#16 - Disabled - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(1).click();
    });

    await test.step.skip('#17 - Disabled - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(2).click();
    });

    await test.step.skip('#18 - Disabled - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(3).click();
    });
    //End - Module - clickModule

    await test.step('#19 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(0).click();
    });

    await test.step('#20 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(1).click();
    });

    await test.step('#21 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(2).click();
    });

    await test.step('#22 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(3).click();
    });
    //Start - Module - clickModule

    await test.step('#23 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(0).click();
    });

    await test.step('#24 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(1).click();
    });

    await test.step('#25 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(2).click();
    });

    await test.step('#26 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(3).click();
    });
    //End - Module - clickModule
    //Start - Module - Module Logout

    await test.step('#27 - click', async () => {
      await page.locator('[data-test="login-container"]').locator('[data-test="login-credentials-container"]').click();
    });

    await test.step('#28 - click', async () => {
      await page.getByRole("button", { name: "Logout", exact: true }).click();
    });

    await test.step('#29 - logout', async () => {
      await page.getByRole("button", { name: "Open Menu", exact: true }).click();
    });
    //End - Module - Module Logout

  }
);

